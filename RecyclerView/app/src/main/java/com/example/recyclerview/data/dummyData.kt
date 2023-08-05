package com.example.recyclerview.data

import com.example.recyclerview.data.model.Friend

val friendList = listOf(
    "Aaran",
    "Aaren",
    "Aarez",
    "Aarman",
    "Aaron",
    "Aaron-James",
    "Aarron",
    "Aaryan",
    "Aaryn",
    "Aayan",
    "Aazaan",
    "Abaan",
    "Abbas",
    "Abdallah",
    "Abdalroof"
).map { Friend(name = it) }

fun getFriendsList(): List<Friend> = friendList