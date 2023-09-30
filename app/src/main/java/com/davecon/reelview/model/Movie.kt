package com.davecon.reelview.model

import androidx.compose.ui.graphics.vector.ImageVector

data class Movie(
    val title: String,
    val year: String,
    val rated: String,
    val runtime: String,
    val genre: String,
    val director: String,
    val poster: String,
    val plot: String,
    val actors: String,
    val metascore: String,
)

fun getMovies(): List<Movie> {
    return listOf(
        Movie(
            title = "The Nightmare Before Christmas",
            year = "1993",
            rated = "PG",
            runtime = "76 min",
            genre = "Animation, Family, Fantasy",
            director = "Henry Selick",
            poster = "https://m.media-amazon.com/images/M/MV5BNWE4OTNiM2ItMjY4Ni00ZTViLWFiZmEtZGEyNGY2ZmNlMzIyXkEyXkFqcGdeQXVyMDU5NDcxNw@@._V1_SX300.jpg",
            plot = "Jack Skellington, the pumpkin king of Halloween Town, is bored with doing the same thing every year for Halloween. One day he stumbles into Christmas Town, and is so taken with the idea of Christmas that he tries to get the resident bats, ghouls, and goblins of Halloween Town to help him put on Christmas instead of Halloween -- but alas, they can't get it quite right.",
            actors = "Danny Elfman, Chris Sarandon, Catherine O'Hara",
            metascore = "82",
        ),
        Movie(
            title = "Friday the 13th",
            year = "1980",
            rated = "R",
            runtime = "95 min",
            genre = "Horror, Mystery, Thriller",
            director = "Sean S. Cunningham",
            poster = "https://m.media-amazon.com/images/M/MV5BNWMxYTYzYWQtNGZmNy00MTg5LTk1N2MtNzQ5NjQxYjQ5NTJhXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg",
            plot = "In 1957, a young boy named Jason drowns in a lake near Camp Crystal Lake. The next year, two counselors are murdered. In 1980, a descendant of the original owners reopens Camp Crystal Lake with some counselors' help. The counselors gets killed one by one by a mysterious person. Could it be Jason, out for revenge?",
            actors = "Betsy Palmer, Adrienne King, Jeannine Taylor",
            metascore = "22"
        ),
        Movie(
            title = "Halloween",
            year = "1978",
            rated = "R",
            runtime = "91 min",
            genre = "Horror, Thriller",
            director = "John Carpenter",
            poster = "https://m.media-amazon.com/images/M/MV5BNzk1OGU2NmMtNTdhZC00NjdlLWE5YTMtZTQ0MGExZTQzOGQyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg",
            plot = "The year is 1963, the night: Halloween. Police are called to 43 Lampkin Ln. only to discover that 15 year old Judith Myers has been stabbed to death, by her 6 year-old brother, Michael. After being institutionalized for 15 years, Myers breaks out on the night before Halloween. No one knows, nor wants to find out, what will happen on October 31st 1978 besides Myers' psychiatrist, Dr. Loomis. He knows Michael is coming back to Haddonfield, but by the time the town realizes it, it'll be too late for many people.",
            actors = "Donald Pleasence, Jamie Lee Curtis, Tony Moran",
            metascore = "87"

        ),
        Movie(
            title = "Hocus Pocus",
            year = "1993",
            rated = "PG",
            runtime = "96 min",
            genre = "Comedy, Family, Fantasy",
            director = "Kenny Ortega",
            poster = "https://m.media-amazon.com/images/M/MV5BNWM3NmRhMGMtOGE4ZC00MDk0LWI1NjMtMjVlNTEwOTcwZTc0XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg",
            plot = "300 years have passed since the Sanderson sisters were executed for practicing dark witchcraft. Returning to life thanks to a combination of a spell spoken before their demise and the accidental actions of Max, the new-kid-in-town, the sisters have but one night to secure their continuing existence...",
            actors = "Bette Midler, Sarah Jessica Parker, Kathy Najimy",
            metascore = "43"
        ),
        Movie(
            title = "The Shining",
            year = "1980",
            rated = "R",
            runtime = "146 min",
            genre = "Drama, Horror",
            director = "Stanley Kubrick",
            poster = "https://m.media-amazon.com/images/M/MV5BZWFlYmY2MGEtZjVkYS00YzU4LTg0YjQtYzY1ZGE3NTA5NGQxXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg",
            plot = "Haunted by a persistent writer's block, the aspiring author and recovering alcoholic, Jack Torrance, drags his wife, Wendy, and his gifted son, Danny, up snow-capped Colorado's secluded Overlook Hotel after taking up a job as an off-season caretaker. As the cavernous hotel shuts down for the season, the manager gives Jack a grand tour, and the facility's chef, the ageing Mr Hallorann, has a fascinating chat with Danny about a rare psychic gift called \"The Shining\", making sure to warn him about the hotel's abandoned rooms, and, in particular, the off-limits Room 237. However, instead of overcoming the dismal creative rut, little by little, Jack starts losing his mind, trapped in an unforgiving environment of seemingly endless snowstorms, and a gargantuan silent prison riddled with strange occurrences and eerie visions. Now, the incessant voices inside Jack's head demand sacrifice. Is Jack capable of murder?",
            actors = "Jack Nicholson, Shelley Duvall, Danny Lloyd",
            metascore = "66"
        ),
        Movie(
            title = "The Conjuring",
            year = "2013",
            rated = "R",
            runtime = "112 min",
            genre = "Horror, Mystery, Thriller",
            director = "James Wan",
            poster = "https://m.media-amazon.com/images/M/MV5BMTM3NjA1NDMyMV5BMl5BanBnXkFtZTcwMDQzNDMzOQ@@._V1_SX300.jpg",
            plot = "In 1971, Carolyn and Roger Perron move their family into a dilapidated Rhode Island farm house and soon strange things start happening around it with escalating nightmarish terror. In desperation, Carolyn contacts the noted paranormal investigators, Ed and Lorraine Warren, to examine the house. What the Warrens discover is a whole area steeped in a satanic haunting that is now targeting the Perron family wherever they go. To stop this evil, the Warrens will have to call upon all their skills and spiritual strength to defeat this spectral menace at its source that threatens to destroy everyone involved.",
            actors = "Patrick Wilson, Vera Farmiga, Ron Livingston",
            metascore = "68",
        ),
        Movie(
            title = "The Exorcist",
            year = "1973",
            rated = "R",
            runtime = "122 min",
            genre = "Horror",
            director = "William Friedkin",
            poster = "https://m.media-amazon.com/images/M/MV5BYWFlZGY2NDktY2ZjOS00ZWNkLTg0ZDAtZDY4MTM1ODU4ZjljXkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_SX300.jpg",
            plot = "A visiting actress in Washington, D.C., notices dramatic and dangerous changes in the behavior and physical make-up of her 12-year-old daughter. Meanwhile, a young priest at nearby Georgetown University begins to doubt his faith while dealing with his mother's terminal sickness. And, book-ending the story, a frail, elderly priest recognizes the necessity for a show-down with an old demonic enemy.",
            actors = "Ellen Burstyn, Max von Sydow, Linda Blair",
            metascore = "81"
        )
    )
}