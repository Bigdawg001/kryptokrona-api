// Copyright (c) 2023-2023, The Kryptokrona Developers
//
// Written by Marcus Cvjeticanin
//
// All rights reserved.
//
// Redistribution and use in source and binary forms, with or without modification, are
// permitted provided that the following conditions are met:
//
// 1. Redistributions of source code must retain the above copyright notice, this list of
//    conditions and the following disclaimer.
//
// 2. Redistributions in binary form must reproduce the above copyright notice, this list
//    of conditions and the following disclaimer in the documentation and/or other
//    materials provided with the distribution.
//
// 3. Neither the name of the copyright holder nor the names of its contributors may be
//    used to endorse or promote products derived from this software without specific
//    prior written permission.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY
// EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
// MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
// THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
// SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
// PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
// INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
// STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF
// THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

package org.kryptokrona.api.services

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.kryptokrona.api.models.Supplies
import org.kryptokrona.api.models.Supply
import org.kryptokrona.api.models.supplies
import org.kryptokrona.api.plugins.DatabaseFactory.db
import org.ktorm.dsl.*
import org.ktorm.entity.add
import org.ktorm.entity.count
import org.ktorm.entity.find
import org.ktorm.entity.removeIf
import org.slf4j.LoggerFactory

class SupplyServiceImpl : SupplyService {

    private val logger = LoggerFactory.getLogger("SupplyServiceImpl")

    override suspend fun getAll(size: Int, page: Int): List<Supply> = withContext(Dispatchers.IO) {
        db.from(Supplies)
            .select()
            .offset((page - 1) * size)
            .limit(size)
            .map { row -> Supplies.createEntity(row) }
    }

    override suspend fun getById(id: Long): Supply? = withContext(Dispatchers.IO) {
        this.runCatching {
            db.supplies.find { it.id eq id }
        }.onFailure {
            logger.error("Error while getting supply by id: $id", it)
        }.getOrNull()
    }

    override suspend fun save(supply: Supply): Unit = withContext(Dispatchers.IO) {
        this.runCatching {
            db.supplies.add(supply)
        }.onFailure {
            logger.error("Error while saving supply: $supply", it)
        }.getOrNull()
    }

    override suspend fun delete(id: Long): Unit = withContext(Dispatchers.IO) {
        this.runCatching {
            db.supplies.removeIf { it.id eq id }
        }.onFailure {
            logger.error("Error while deleting supply by id: $id", it)
        }.getOrNull()
    }

    override suspend fun getTotalCount(): Int = withContext(Dispatchers.IO) {
        this.runCatching {
            db.supplies.count()
        }.onFailure {
            logger.error("Error while getting total count of supplies", it)
        }.getOrNull() ?: 0
    }

}