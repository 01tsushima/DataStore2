package com.datastore.test.feature.proto.ui

import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.datastore.test.R
import com.datastore.test.databinding.ItemTagsBinding
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder

class TagsController() : BindableItemController<String, TagsController.Holder>() {

    override fun createViewHolder(parent: ViewGroup): Holder {
        return Holder(parent)
    }

    override fun getItemId(data: String): Any = data

    inner class Holder(parent: ViewGroup) : BindableViewHolder<String>(parent, R.layout.item_tags) {

        private val binding by viewBinding(ItemTagsBinding::bind)

        override fun bind(data: String?) {

        }
    }
}