package com.msaitodev.salesclerk.humanmed.di

import com.msaitodev.core.common.config.AppAssetConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object QuizConfigModule {

    @Provides
    @Singleton
    fun provideAppAssetConfig(): AppAssetConfig {
        return AppAssetConfig(
            assetDataDirectory = "quiz_data",
            totalExamQuestions = 120, // 登録販売者試験の総出題数
            passingScoreThreshold = 0.7f // 合格基準（概ね7割以上かつ各項目3.5〜4割以上だが、全体閾値として0.7を設定）
        )
    }
}
