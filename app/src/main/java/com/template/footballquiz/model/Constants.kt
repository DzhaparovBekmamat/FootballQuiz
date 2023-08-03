package com.template.footballquiz.model

import com.template.footballquiz.R

/**
 * Author: Dzhaparov Bekmamat
 */
object Constants {
    fun getQuestion(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()
        val que1 = Question(
            1,
            "Who is the all-time leading goal scorer in FIFA World Cup history?",
            R.drawable.a,
            "Lionel Messi",
            "Cristiano Ronaldo",
            "Pele",
            "Neymar Jr.",
            3
        )
        val que2 = Question(
            2,
            "Which country won the 2018 FIFA World Cup?",
            R.drawable.b,
            "Brazil",
            "Germany",
            "France",
            "Spain",
            3
        )
        val que3 = Question(
            3,
            "Which football club has won the most UEFA Champions League titles?",
            R.drawable.c,
            "FC Barcelona",
            "Real Madrid",
            "Manchester United",
            "Liverpool",
            2
        )
        val que4 = Question(
            4,
            "Who is often referred to as \"The Special One\" in football?",
            R.drawable.d,
            "Jurgen Klopp",
            "Zinedine Zidane",
            "Jose Mourinho",
            "Pep Guardiola",
            3
        )
        val que5 = Question(
            5,
            "Which player is known for his famous \"Bicycle Kick\" goal against Juventus in the UEFA Champions League?",
            R.drawable.e,
            "Lionel Messi",
            "Cristiano Ronaldo",
            "Sergio Ramos",
            "Gareth Bale",
            2
        )
        val que6 = Question(
            6,
            "Which city hosted the 2014 FIFA World Cup final?",
            R.drawable.f,
            "Rio de Janeiro",
            "Berlin",
            "Moscow",
            "Brasilia",
            1
        )
        val que7 = Question(
            7,
            "Who is the most expensive football player in history as of 2021?",
            R.drawable.g,
            "Kylian Mbappe",
            "Neymar Jr.",
            "Cristiano Ronaldo",
            "Lionel Messi",
            2
        )
        val que8 = Question(
            8,
            "Which player is known for his exceptional dribbling skills and \"Nutmeg\" abilities?",
            R.drawable.h,
            "Andres Iniesta",
            "Eden Hazard",
            "Luka Modric",
            "Kevin De Bruyne",
            2
        )
        val que9 = Question(
            9,
            "Which player is often referred to as the \"King of Assists\" due to his creative playmaking abilities?",
            R.drawable.i,
            "Mesut Ozil",
            "Toni Kross",
            "David Silva",
            "Kevin De Bruyne",
            4
        )
        val que10 = Question(
            10,
            "Which country has won the most FIFA World Cup titles?",
            R.drawable.j,
            "Brazil",
            "Germany",
            "Italy",
            "Argentina",
            1
        )
        val que11 = Question(
            11,
            "Who is the captain of the England national football team?",
            R.drawable.k,
            "Harry Kane",
            "Raheem Sterling",
            "Marcus Rashford",
            "Jordan Henderson",
            1
        )
        val que12 = Question(
            12,
            "Which legendary footballer is known as \"The Black Pearl\"?",
            R.drawable.l,
            "Pele",
            "Diego Maradona",
            "George Weah",
            "Ronaldinho",
            1
        )
        val que13 = Question(
            13,
            "Which club won the UEFA Champions League in the 2020-2021 season?",
            R.drawable.m,
            "FC Barcelona",
            "Manchester City",
            "Chelsea",
            "Bayern Munich",
            3
        )
        val que14 = Question(
            14,
            "Which player won the FIFA Ballon d'Or in 2020?",
            R.drawable.n,
            "Lionel Messi",
            "Cristiano Ronaldo",
            "Robert Lewandowski",
            "Neymar Jr.",
            3
        )
        val que15 = Question(
            15,
            "In which country is the football club Paris Saint-Germain (PSG) based?",
            R.drawable.o,
            "England",
            "France",
            "Spain",
            "Italy",
            2
        )
        val que16 = Question(
            16,
            "Which player is known for his incredible free-kick skills and is often called \"Beckham-esque\"?",
            R.drawable.pen,
            "Lionel Messi",
            "Cristiano Ronaldo",
            "David Beckham",
            "Mohamed Salah",
            3
        )
        val que17 = Question(
            17,
            "Which footballer has won the most Ballon d'Or awards in history?",
            R.drawable.q,
            "Lionel Messi",
            "Cristiano Ronaldo",
            "Michel Platini",
            "Johan Cruyff",
            1
        )
        val que18 = Question(
            18,
            "Which country hosted the 2010 FIFA World Cup?",
            R.drawable.world,
            "Germany",
            "South Africa",
            "Brazil",
            "France",
            2
        )
        val que19 = Question(
            19,
            "Which player is known as the \"Egyptian King\" due to his outstanding performances for Liverpool FC?",
            R.drawable.s,
            "Sadio Mane",
            "Roberto Firmino",
            "Mo Salah",
            "Virgil van Dijk",
            3
        )
        val que20 = Question(
            20,
            "Who is considered the best goalkeeper of all time and is known for his safe hands and acrobatic saves?",
            R.drawable.t,
            "Manuel Neuer",
            "Gianluigi Buffon",
            "Lev Yashin",
            "Iker Casillas",
            3
        )
        questionsList.add(que1)
        questionsList.add(que2)
        questionsList.add(que3)
        questionsList.add(que4)
        questionsList.add(que5)
        questionsList.add(que6)
        questionsList.add(que7)
        questionsList.add(que8)
        questionsList.add(que9)
        questionsList.add(que10)
        questionsList.add(que11)
        questionsList.add(que12)
        questionsList.add(que13)
        questionsList.add(que14)
        questionsList.add(que15)
        questionsList.add(que16)
        questionsList.add(que17)
        questionsList.add(que18)
        questionsList.add(que19)
        questionsList.add(que20)
        return questionsList
    }
}