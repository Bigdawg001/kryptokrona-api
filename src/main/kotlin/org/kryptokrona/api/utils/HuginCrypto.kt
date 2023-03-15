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

package org.kryptokrona.api.utils

import org.slf4j.LoggerFactory
import javax.xml.bind.DatatypeConverter.parseHexBinary

/**
 * Hugin crypto.
 *
 * Note that this will be removed once it is implemented in the SDK.
 */

private val logger = LoggerFactory.getLogger("HuginCrypto")

fun trimExtra(extra: String): String? {
    return try {
        fromHex(extra.substring(66))
    } catch (e: Exception) {
        // return fromHex(Buffer);
        //TODO not done
        null
    }
}

/**
 * Converts hex value to string.
 *
 * @param hex - Hex value.ß
 * @return Returns hex value to string
 */
fun fromHex(hex: String?): String? {
    var str: String?
    try {
        val bytes: ByteArray = parseHexBinary(hex)
        val result = String(bytes, Charsets.UTF_8)
        str = result.substring(6)
    } catch (e: Exception) {
        str = hex
        logger.error("Invalid hex input.")
    }
    return str
}

fun isBoxObject(str: String): Boolean {
    return str.contains("box")
}

fun isSealedBoxObject(str: String): Boolean {
    return str.contains("sb")
}
