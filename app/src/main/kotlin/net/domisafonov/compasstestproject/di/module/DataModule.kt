package net.domisafonov.compasstestproject.di.module

import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import net.domisafonov.compasstestproject.data.RoomPageRepository
import net.domisafonov.compasstestproject.data.pageapi.PageApi
import net.domisafonov.compasstestproject.data.pagecache.PageCacheDb
import net.domisafonov.compasstestproject.di.IoDispatcher
import net.domisafonov.compasstestproject.domain.repository.PageRepository

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Reusable
    fun pageRepository(
        db: PageCacheDb,
        pageApi: PageApi,
        @IoDispatcher ioDispatcher: CoroutineDispatcher,
    ): PageRepository = RoomPageRepository(
        pageCacheDao = db.pageCache(),
        pageApi = pageApi,
        ioDispatcher = ioDispatcher,
    )
}
