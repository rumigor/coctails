package ru.rumigor.drinks.scheduler

import ru.rumigor.drinks.scheduler.DefaultSchedulers
import ru.rumigor.drinks.scheduler.Schedulers

object SchedulersFactory {
    fun create(): Schedulers = DefaultSchedulers()
}