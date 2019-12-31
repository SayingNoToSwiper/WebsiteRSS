package com.damiengo.websiterss.category

import com.damiengo.websiterss.R
import javax.inject.Inject

class ClassCategoriesBuilder @Inject constructor() : CategoriesBuilder  {

    override fun build(): Map<Int, Category> {
        return mapOf(
            R.id.nav_actu       to Category("The Vigilante News",  "https://rss-bridge.snopyta.org/?action=display&bridge=Facebook&context=User&u=thevigilantenews&media_type=all&limit=-1&format=Atom"),
        )
    }

}
