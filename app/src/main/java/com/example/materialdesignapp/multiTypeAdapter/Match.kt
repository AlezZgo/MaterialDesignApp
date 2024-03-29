package com.example.materialdesignapp.multiTypeAdapter

interface Match<T> : MatchId<T>, MatchContent<T>

interface MatchContent<T> {
    fun matches(model: T): Boolean
}

interface MatchId<T> {
    fun matchesId(model: T): Boolean
}