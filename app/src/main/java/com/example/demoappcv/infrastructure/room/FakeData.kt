package com.example.demoappcv.infrastructure.room

import com.example.demoappcv.view.MovieAdapterItem
import com.example.demoappcv.infrastructure.Movie

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
                1,
                "Historia małżeńska",
                8.0,
                "https://fwcdn.pl/fpo/80/90/818090/7902235.3.jpg"
            )
        ),
        MovieAdapterItem(
            Movie(
                2,
                "Historia małżeńska",
                8.0,
                "https://fwcdn.pl/fpo/80/90/818090/7902235.3.jpg"
            )
        ),
        MovieAdapterItem(
            Movie(
                3,
                "Historia małżeńska",
                8.0,
                "https://fwcdn.pl/fpo/80/90/818090/7902235.3.jpg"
            )
        ),
        MovieAdapterItem(
            Movie(
                4,
                "Historia małżeńska",
                8.0,
                "https://fwcdn.pl/fpo/80/90/818090/7902235.3.jpg"
            )
        ),
        MovieAdapterItem(
            Movie(
                5,
                "Historia małżeńska",
                8.0,
                "https://fwcdn.pl/fpo/80/90/818090/7902235.3.jpg"
            )
        ),
        MovieAdapterItem(
            Movie(
                6,
                "Historia małżeńska",
                8.0,
                "https://fwcdn.pl/fpo/80/90/818090/7902235.3.jpg"
            )
        ),
        MovieAdapterItem(
            Movie(
                7,
                "Historia małżeńska",
                8.0,
                "https://fwcdn.pl/fpo/80/90/818090/7902235.3.jpg"
            )
        )
    )
}