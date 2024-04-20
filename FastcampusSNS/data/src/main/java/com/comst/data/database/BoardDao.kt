package com.comst.data.database

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.comst.data.model.BoardDTO

@Dao
interface BoardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(board:List<BoardDTO>)

    @Query("DELETE FROM boarddto")
    fun deleteAll()

    @Query("SELECT * FROM boarddto ORDER BY id DESC")
    fun getAll():PagingSource<Int, BoardDTO>
}