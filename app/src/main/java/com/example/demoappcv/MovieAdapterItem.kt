package com.example.demoappcv

sealed class AdapterItem

class MovieAdapterItem(val movie: Movie) : AdapterItem()