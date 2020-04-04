package com.example.demoappcv.view

import com.example.demoappcv.infrastructure.Movie

sealed class AdapterItem

class MovieAdapterItem(val movie: Movie) : AdapterItem()