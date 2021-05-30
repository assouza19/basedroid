package com.br.basedroid.utils

interface Mapper<S, T> {
    fun map(source: S): T
}