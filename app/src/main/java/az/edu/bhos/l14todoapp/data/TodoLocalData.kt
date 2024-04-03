package az.edu.bhos.l14todoapp.data

import az.edu.bhos.l14todoapp.data.dto.TodoLocalDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

interface TodoLocalData {
    fun observeItems(): Flow<List<TodoLocalDto>>
    suspend fun save(data: List<TodoLocalDto>)
}

//class TodoLocalDataImpl(
//    private val todoDao: TodoDao
//) : TodoLocalData {
//
//    override fun observeItems(): Flow<List<TodoLocalDto>> {
//        // TODO: use todoDao
//        // TODO: return the items by `weekday` order (Monday, Tue, Wed..)
//        return flowOf(emptyList())
//    }
//
//    override suspend fun save(data: List<TodoLocalDto>) {
//        // TODO: use todoDao
//
//        // TODO: make sure your insert query will not cause conflict
//        //  (you will experience this on second insert attempt)
//    }
//
//}
class TodoLocalDataImpl(
    private val todoDao: TodoDao
) : TodoLocalData {

    override fun observeItems(): Flow<List<TodoLocalDto>> {
        return todoDao.getTodos()
    }

    override suspend fun save(data: List<TodoLocalDto>) {
        todoDao.insertTodos(data)
    }
}