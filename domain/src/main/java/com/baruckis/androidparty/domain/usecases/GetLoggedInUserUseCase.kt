/*
 * Copyright 2020 Andrius Baruckis www.baruckis.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.baruckis.androidparty.domain.usecases

import com.baruckis.androidparty.domain.entity.LoggedInUserEntity
import com.baruckis.androidparty.domain.repository.DataRepository
import com.baruckis.androidparty.domain.usecases.base.SynchronousUseCase
import javax.inject.Inject


class GetLoggedInUserUseCase @Inject constructor(
    private val dataRepository: DataRepository
) : SynchronousUseCase<LoggedInUserEntity?, Any> {

    override fun execute(params: Any?): LoggedInUserEntity? {
        return dataRepository.getLoggedInUser()
    }

}