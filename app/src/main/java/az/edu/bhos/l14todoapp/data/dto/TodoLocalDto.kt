package az.edu.bhos.l14todoapp.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import az.edu.bhos.l14todoapp.entities.TodoEntity

@Entity(tableName = "todos")
data class TodoLocalDto(
    @PrimaryKey
    val id: String,
    val title: String,
    val completed: Boolean,
    val weekday: String,
) {
    fun toEntity(): TodoEntity {
        return TodoEntity(
            id =id,
            title =title,
            completed = completed,
            weekday = weekday
        )
    }
}