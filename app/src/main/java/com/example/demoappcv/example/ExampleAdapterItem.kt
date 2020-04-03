package com.example.demoappcv.example

sealed class ExampleAdapterItem

class MovieAdapterItem(val movie: ExampleMovie) : ExampleAdapterItem()

class AdvertAdapterItem(advertUrl: String) : ExampleAdapterItem()