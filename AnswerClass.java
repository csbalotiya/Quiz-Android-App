package com.example.quizgame;

public class AnswerClass {

    private int optionA,optionB,optionC,optionD,questionId,answerId;

    public AnswerClass(int queId , int optiona ,int optionb ,int optionc ,int optiond ,int ansId){

        questionId = queId ;
        optionA = optiona;
        optionB = optionb;
        optionC = optionc;
        optionD = optiond;
        answerId = ansId;
    }

    public int getOptionA() { return optionA; }

    public int getOptionB() { return optionB; }

    public int getOptionC() { return optionC; }

    public int getOptionD() { return optionD; }

    public int getQuestionId(){ return questionId; }

    public  int getAnswerId(){ return answerId; }

}
