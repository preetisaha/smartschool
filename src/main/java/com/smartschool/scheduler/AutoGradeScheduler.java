package com.smartschool.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.smartschool.DAO.AnswerDAO;
import com.smartschool.DAO.ExamDAO;
import com.smartschool.DAO.GradeDAO;
import com.smartschool.DAO.QuestionDAO;
import com.smartschool.domain.Answer;
import com.smartschool.domain.Choice;
import com.smartschool.domain.Exam;
import com.smartschool.domain.Question;

@Component
public class AutoGradeScheduler {

	@Autowired
	ExamDAO examDAO;
	
	@Autowired
	QuestionDAO questionDAO;
	
	@Autowired
	AnswerDAO answerDAO;
	
	@Autowired
	GradeDAO gradeDAO;
	
	@Scheduled(cron = "0 0/5 * * * *")
	public void schedule() {
		List<Exam> finishedExams = examDAO.getFinishedExams();
		
		for (Exam finishedExam : finishedExams) {
			List<Question> multiChoiceQuestions = questionDAO.getMultiChoiceQuestions(finishedExam.getExamId());
			
			for (Question multiChoiceQuestion : multiChoiceQuestions) {
				List<Choice> correctChoices = questionDAO.getCorrectChoice(multiChoiceQuestion.getQuestionId());
				
				List<Answer> answers = answerDAO.getAnswersByQuestionID(multiChoiceQuestion.getQuestionId());
				
				for (Answer answer : answers) {
					String[] userAnswers = answer.getAnswer().split(",");

					boolean correct = true;
					
					if (userAnswers.length != correctChoices.size()){
						correct = false;
					} else {
						choice:
						for (String userChoiceStr : userAnswers) {
							int multipleChoiceId = Integer.parseInt(userChoiceStr);
							
							for (Choice correctChoice : correctChoices) {
								if (correctChoice.getMultipleChoiceId() == multipleChoiceId)
									continue choice;
							}
							
							correct = false;
							break choice;
						}
					}
					
					if (correct) {
						answerDAO.scoreAnswer(answer.getAnswerId(), multiChoiceQuestion.getMarks());
						gradeDAO.updateGrade(answer.getStudent_id(), 
								multiChoiceQuestion.getExamId(), 
								finishedExam.getCourseId(), 
								multiChoiceQuestion.getMarks());
					} else {
						answerDAO.scoreAnswer(answer.getAnswerId(), 0);
					}
					
					
				}
			}
			examDAO.updateGradeStatus(finishedExam.getExamId());
		}
	}
}
