package az.edu.bhos.l14todoapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import az.edu.bhos.l14todoapp.data.dto.TodoLocalDto
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Query("SELECT * FROM todos ORDER BY (CASE weekday WHEN 'Monday' THEN 1 WHEN 'Tuesday' THEN 2 WHEN 'Wednesday' THEN 3 WHEN 'Thursday' THEN 4 WHEN 'Friday' THEN 5 WHEN 'Saturday' THEN 6 WHEN 'Sunday' THEN 7 END)")
    fun getAllTodos(): Flow<List<TodoLocalDto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todos: List<TodoLocalDto>)
}