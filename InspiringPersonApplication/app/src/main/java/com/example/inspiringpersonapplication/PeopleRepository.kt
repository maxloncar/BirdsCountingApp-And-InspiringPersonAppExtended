package com.example.inspiringpersonapplication

import kotlin.random.Random

object PeopleRepository {
    private val inspiringPersons = mutableListOf<InspiringPerson>(
        InspiringPerson(1, "Steve Jobs", "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cc/Steve_Jobs_with_Wendell_Brown_in_January_1984%2C_at_the_launch_of_Brown%27s_Hippo-C_software_for_Macintosh_%28cropped%29.jpg/330px-Steve_Jobs_with_Wendell_Brown_in_January_1984%2C_at_the_launch_of_Brown%27s_Hippo-C_software_for_Macintosh_%28cropped%29.jpg", "February 24, 1955 – October 5, 2011", "Steven Paul Jobs was an American business magnate, industrial designer, investor, and media proprietor. He was the chairman, the chief executive officer (CEO), and a co-founder of Apple Inc."),
        InspiringPerson(2, "Bill Gates", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/Bill_Gates_2018.jpg/330px-Bill_Gates_2018.jpg", "October 28, 1955", "William Henry Gates III is an American business magnate, software developer, investor, author, landowner and philanthropist. He is a co-founder of Microsoft Corporation."),
        InspiringPerson(3, "Elon Musk", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/85/Elon_Musk_Royal_Society_%28crop1%29.jpg/330px-Elon_Musk_Royal_Society_%28crop1%29.jpg", "June 28, 1971", "Elon Reeve Musk is a business magnate, industrial designer, and engineer. He is the founder, CEO, CTO, and chief designer of SpaceX; early stage investor, CEO, and product architect of Tesla, Inc."),
        InspiringPerson(4, "Larry Page", "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Larry_Page_in_the_European_Parliament%2C_17.06.2009_%28cropped%29.jpg/330px-Larry_Page_in_the_European_Parliament%2C_17.06.2009_%28cropped%29.jpg", "March 26, 1973", "Lawrence Edward Page is an American computer scientist and Internet entrepreneur. He is best known as one of the co-founders of Google along with Sergey Brin."),
        InspiringPerson(5, "Tim Berners-Lee", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4e/Sir_Tim_Berners-Lee_%28cropped%29.jpg/330px-Sir_Tim_Berners-Lee_%28cropped%29.jpg", "June 8, 1955", "Sir Timothy John Berners-Lee, also known as TimBL, is an English computer scientist best known as the inventor of the World Wide Web.")
    )

    private val inspiringPersonsQuotes = mutableMapOf(      //name of the person is a key in mutableMap
        "Steve Jobs" to mutableListOf(                      //list of quotes is a value in mutableMaps
            "We're here to put a dent in the universe. Otherwise why else even be here?",
            "Stay hungry. Stay foolish.",
            "Don't let the noise of other's opinions drown out your own inner voice."
        ),
        "Bill Gates" to mutableListOf(
            "Success is a lousy teacher. It seduces smart people into thinking they can't lose.",
            "To win big, you sometimes need to take big risks.",
            "If you are born poor it's not your mistake, but if you die poor it's your mistake."
        ),
        "Elon Musk" to mutableListOf(
            "I think it is possible for ordinary people to choose to be extraordinary.",
            "When something is important enough, you do it even if the odds are not in your favor.",
            "Take risks now and do something bold. You won't regret it."
        ),
        "Larry Page" to mutableListOf(
            "If you're changing the world, you're working on important things. You're excited to get up in the morning.",
            "You never lose a dream, it just incubates as a hobby.",
            "Always deliver more than expected."
        ),
        "Tim Berners-Lee" to mutableListOf(
            "The web does not just connect machines, it connects people.",
            "We need diversity of thought in the world to face the new challenges.",
            "A hacker to me is someone creative who does wonderful things."
        )
    )

    fun getInspiringPersons() : List<InspiringPerson> = inspiringPersons
    fun getInspiringPerson(personName: String): InspiringPerson = inspiringPersons.first{it.name == personName}
    fun insertInspiringPerson(inspiringPerson: InspiringPerson) = inspiringPersons.add(inspiringPerson)
    fun deleteInspiringPerson(inspiringPerson: InspiringPerson) = inspiringPersons.remove(inspiringPerson)

    fun getInspiringPersonQuote(inspiringPersonName: String): String? {
        val quoteIndex = inspiringPersonsQuotes[inspiringPersonName]?.let { Random.nextInt(it.size) }    //random number of quote
        return quoteIndex?.let { inspiringPersonsQuotes[inspiringPersonName]?.get(it) }     //getting the element from map with given random number as index
    }

    fun insertInspiringPersonQuote(inspiringPersonName: String, inspiringPersonQuote: String){
        if (!inspiringPersonsQuotes.containsKey(inspiringPersonName)) {
            inspiringPersonsQuotes[inspiringPersonName] = mutableListOf(inspiringPersonQuote)
        }
    }
}
