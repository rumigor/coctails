package ru.rumigor.drinks.scheduler

import io.reactivex.Scheduler


interface Schedulers {

    fun background(): Scheduler
    fun main(): Scheduler

}