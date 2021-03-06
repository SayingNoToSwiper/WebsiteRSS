package com.damiengo.websiterss.article.json

import com.damiengo.websiterss.ui.articledetail.model.Model
import com.damiengo.websiterss.ui.articledetail.model.ModelFactory
import com.damiengo.websiterss.util.DaggerDaggerComponent
import com.google.gson.annotations.SerializedName
import java.util.*
import javax.inject.Inject

class ItemObject {

    @Inject
    lateinit var modelFactory: ModelFactory

    @SerializedName("paragraphs")
    lateinit var paragraphs: List<Paragraph>

    @SerializedName("long_title")
    lateinit var title: String

    @SerializedName("date_update")
    lateinit var dateUpdate: Date

    @SerializedName("subhead")
    lateinit var subhead: Subhead

    @SerializedName("media")
    lateinit var media: Media

    init {
        DaggerDaggerComponent.create().inject(this)
    }

    fun getModels(): MutableList<Model> {
        val models = mutableListOf<Model>()

        if(hasMedia()) {
            models.add(media.getModel())
        }

        if(hasSubhead()) {
            models.add(modelFactory.buildInfoModel(dateUpdate, subhead.elements))
        }

        if(hasTitle()) {
            models.add(modelFactory.buildTitle(title))
        }

        if(hasParagraphs()) {
            paragraphs.forEach {
                models.add(it.getModel())
            }
        }

        return models
    }

    private fun hasMedia(): Boolean {
        return ::media.isInitialized
    }

    private fun hasTitle(): Boolean {
        return ::title.isInitialized
    }

    private fun hasSubhead(): Boolean {
        return ::subhead.isInitialized
    }

    private fun hasParagraphs(): Boolean {
        return ::paragraphs.isInitialized && paragraphs.isNotEmpty()
    }

}