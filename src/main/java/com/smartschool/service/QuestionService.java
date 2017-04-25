package com.smartschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartschool.DAO.QuestionDAO;
import com.smartschool.domain.Question;

@Service
public class QuestionService {

	@Autowired
	QuestionDAO questionDAO;

	public void saveQuestion(int examId, int chooseOption, String question, int marks, String[] optionSelectArray,
			String[] optionTextArray) {
		boolean multipleChoice = (chooseOption == 0 ? false : true);
		Question questionDomain = questionDAO.saveQuestion(examId, multipleChoice, question, marks);

		if (multipleChoice) {
			for (int choiceIndex = 0; choiceIndex < optionTextArray.length; choiceIndex++) {
				boolean isValid = optionSelectArray[choiceIndex].equals("1") ? true : false;
				String choice = optionTextArray[choiceIndex];

				questionDAO.saveChoice(questionDomain.getQuestionId(), isValid, choice);
			}
		}

	}

}
