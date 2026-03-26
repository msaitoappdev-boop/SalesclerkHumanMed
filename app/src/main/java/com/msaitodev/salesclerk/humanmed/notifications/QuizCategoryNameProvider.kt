package com.msaitodev.salesclerk.humanmed.notifications

import android.content.Context
import com.msaitodev.salesclerk.humanmed.R
import com.msaitodev.quiz.core.domain.repository.CategoryNameProvider
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * クイズアプリ向けのカテゴリ名称供給実装。
 * ディレクトリ名（ID）を、Hub層の strings.xml に定義された日本語名に変換します。
 */
@Singleton
class QuizCategoryNameProvider @Inject constructor(
    @ApplicationContext private val context: Context
) : CategoryNameProvider {
    override fun getDisplayName(categoryId: String): String {
        val resId = when (categoryId) {
            "01_characteristics" -> R.string.cat_01_characteristics
            "02_body_function" -> R.string.cat_02_body_function
            "03_medicine_action" -> R.string.cat_03_medicine_action
            "04_regulations" -> R.string.cat_04_regulations
            "05_safety_measures" -> R.string.cat_05_safety_measures
            "unclassified" -> R.string.cat_unclassified
            else -> null
        }
        
        return if (resId != null) {
            context.getString(resId)
        } else {
            // マッピングがない場合は ID をそのまま返し、不備に気づきやすくする
            categoryId
        }
    }
}
