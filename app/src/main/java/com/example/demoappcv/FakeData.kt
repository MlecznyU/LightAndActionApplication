package com.example.demoappcv

object FakeData {
    val moviesTitle = arrayOf(
        "Historia małżeńska", "Carol", "Gangi Nowego Jorku"
    )
    val moviesPostersHttp = arrayOf(
        "https://fwcdn.pl/fpo/80/90/818090/7902235.3.jpg",
        "https://fwcdn.pl/fpo/58/78/655878/7723418_1.3.jpg",
        "https://fwcdn.pl/fpo/57/78/5778/7531037.3.jpg"
    )
    val moviesScore = arrayOf(
        "score: 8", "score: 7.5", "score: 6.7"
    )

    val movieList = listOf<MovieAdapterItem>(
        MovieAdapterItem(
            Movie(
                "Historia małżeńska",
                8.0,
                "https://fwcdn.pl/fpo/80/90/818090/7902235.3.jpg"
            )
        ),
        MovieAdapterItem(
            Movie(
                "Historia małżeńska",
                8.0,
                "https://fwcdn.pl/fpo/80/90/818090/7902235.3.jpg"
            )
        ),
        MovieAdapterItem(
            Movie(
                "Historia małżeńska",
                8.0,
                "https://fwcdn.pl/fpo/80/90/818090/7902235.3.jpg"
            )
        ),
        MovieAdapterItem(
            Movie(
                "Historia małżeńska",
                8.0,
                "https://fwcdn.pl/fpo/80/90/818090/7902235.3.jpg"
            )
        ),
        MovieAdapterItem(
            Movie(
                "Historia małżeńska",
                8.0,
                "https://fwcdn.pl/fpo/80/90/818090/7902235.3.jpg"
            )
        ),
        MovieAdapterItem(
            Movie(
                "Historia małżeńska",
                8.0,
                "https://fwcdn.pl/fpo/80/90/818090/7902235.3.jpg"
            )
        ),
        MovieAdapterItem(
            Movie(
                "Historia małżeńska",
                8.0,
                "https://fwcdn.pl/fpo/80/90/818090/7902235.3.jpg"
            )
        )
    )
}