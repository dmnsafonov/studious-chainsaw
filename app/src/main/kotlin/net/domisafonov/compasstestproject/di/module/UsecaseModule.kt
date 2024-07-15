package net.domisafonov.compasstestproject.di.module

import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import net.domisafonov.compasstestproject.di.IoDispatcher
import net.domisafonov.compasstestproject.domain.repository.PageRepository
import net.domisafonov.compasstestproject.domain.usecase.MakeTenthCharacterTextUc
import net.domisafonov.compasstestproject.domain.usecase.MakeTenthCharacterTextUcImpl
import net.domisafonov.compasstestproject.domain.usecase.MakeWordCountTextUc
import net.domisafonov.compasstestproject.domain.usecase.MakeWordCountTextUcImpl
import net.domisafonov.compasstestproject.domain.usecase.ObserveTenthCharacterTextUc
import net.domisafonov.compasstestproject.domain.usecase.ObserveTenthCharacterTextUcImpl
import net.domisafonov.compasstestproject.domain.usecase.ObserveWordCountTextUc
import net.domisafonov.compasstestproject.domain.usecase.ObserveWordCountTextUcImpl
import net.domisafonov.compasstestproject.domain.usecase.RefreshAboutPageUc
import net.domisafonov.compasstestproject.domain.usecase.RefreshAboutPageUcImpl

@Module
@InstallIn(SingletonComponent::class)
object UsecaseModule {

    @Provides
    @Reusable
    fun makeWordCountText(
        @IoDispatcher ioDispatcher: CoroutineDispatcher,
    ): MakeWordCountTextUc = MakeWordCountTextUcImpl(
        ioDispatcher = ioDispatcher,
    )

    @Provides
    @Reusable
    fun observeWordCountText(
        pageRepository: PageRepository,
        makeWordCountTextUc: MakeWordCountTextUc,
    ): ObserveWordCountTextUc = ObserveWordCountTextUcImpl(
        pageRepository = pageRepository,
        makeWordCountTextUc = makeWordCountTextUc,
    )

    @Provides
    @Reusable
    fun makeTenthCharacterText(
        @IoDispatcher ioDispatcher: CoroutineDispatcher,
    ): MakeTenthCharacterTextUc = MakeTenthCharacterTextUcImpl(
        ioDispatcher = ioDispatcher,
    )

    @Provides
    @Reusable
    fun observeTenthCharacterText(
        pageRepository: PageRepository,
        makeTenthCharacterTextUc: MakeTenthCharacterTextUc,
    ): ObserveTenthCharacterTextUc = ObserveTenthCharacterTextUcImpl(
        pageRepository = pageRepository,
        makeTenthCharacterTextUc = makeTenthCharacterTextUc,
    )

    @Provides
    @Reusable
    fun refreshAboutPage(
        pageRepository: PageRepository,
    ): RefreshAboutPageUc = RefreshAboutPageUcImpl(
        pageRepository = pageRepository,
    )
}
