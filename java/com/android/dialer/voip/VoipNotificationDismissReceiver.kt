/* Copyright (C) 2026 Lunaris AOSP
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
 */
package com.android.dialer.voip

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

/** Re-posts a call notification the user swiped away, while the call is still active. */
class VoipNotificationDismissReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val token = intent.getStringExtra(VoipNotificationListener.EXTRA_TOKEN) ?: return
        VoipNotificationListener.restoreCall(context, token)
    }
}
