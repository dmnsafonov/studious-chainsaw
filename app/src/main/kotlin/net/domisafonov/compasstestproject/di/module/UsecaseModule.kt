package net.domisafonov.compasstestproject.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.domisafonov.compasstestproject.domain.repository.PageRepository
import net.domisafonov.compasstestproject.domain.usecase.MakeTenthCharacterTextUc
import net.domisafonov.compasstestproject.domain.usecase.MakeTenthCharacterTextUcImpl
import net.domisafonov.compasstestproject.domain.usecase.MakeWordCountTextUc
import net.domisafonov.compasstestproject.domain.usecase.MakeWordCountTextUcImpl
import net.domisafonov.compasstestproject.domain.usecase.ObserveTenthCharacterTextUc
import net.domisafonov.compasstestproject.domain.usecase.ObserveTenthCharacterTextUcImpl
import net.domisafonov.compasstestproject.domain.usecase.ObserveWordCountTextUc
import net.domisafonov.compasstestproject.domain.usecase.ObserveWordCountTextUcImpl

@Module
@InstallIn(SingletonComponent::class)
object UsecaseModule {

    @Provides
    fun makeWordCountText(): MakeWordCountTextUc = MakeWordCountTextUcImpl()

    @Provides
    fun observeWordCountText(
        pageRepository: PageRepository,
        makeWordCountTextUc: MakeWordCountTextUc,
    ): ObserveWordCountTextUc = ObserveWordCountTextUcImpl(
        pageRepository = pageRepository,
        makeWordCountTextUc = makeWordCountTextUc,
    )

    @Provides
    fun makeTenthCharacterText(): MakeTenthCharacterTextUc = MakeTenthCharacterTextUcImpl()

    @Provides
    fun observeTenthCharacterText(
        pageRepository: PageRepository,
        makeTenthCharacterTextUc: MakeTenthCharacterTextUc,
    ): ObserveTenthCharacterTextUc = ObserveTenthCharacterTextUcImpl(
        pageRepository = pageRepository,
        makeTenthCharacterTextUc = makeTenthCharacterTextUc,
    )
}
