package com.datastore.test.feature.migration_from_pref.data.local

import javax.inject.Inject

class NotificationLocalSourceDataStorage
@Inject
constructor() : NotificationLocalDataSource {
    override fun getSubscribeNotification(): Boolean =
        true

    override fun notification(subscribe: Boolean) {

    }

}