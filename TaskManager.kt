data class Task(val id: Int, val description: String)

class TaskManager {
  private val tasks = mutableListOf<Task>()
  private var taskIdCounter = 1

  fun addTask(description: String) {
    val task = Task(taskIdCounter++, description)
    tasks.add(task)
    println("Task added: $task")
  }

  fun removeTask(taskId: Int) {
    val taskToRemove = tasks.find { it.id == taskId }
    if (taskToRemove != null) {
      tasks.remove(taskToRemove)
      println("Task removed: $taskToRemove")
    } else {
      println("Task with ID $taskId not found.")
    }
  }

  fun listTasks() {
    if (tasks.isEmpty()) {
      println("No tasks available.")
    } else {
      println("Task List:")
      tasks.forEach { println(it) }
    }
  }
}

fun main() {
  val taskManager = TaskManager()

  while (true) {
    println("\nTask Manager Menu:")
    println("1. Add Task")
    println("2. Remove Task")
    println("3. List Tasks")
    println("4. Exit")
    print("Enter your choice: ")

    when (readLine()?.toIntOrNull()) {
      1 -> {
        print("Enter task description: ")
        val description = readLine() ?: ""
        taskManager.addTask(description)
      }
      2 -> {
        print("Enter task ID to remove: ")
        val taskId = readLine()?.toIntOrNull() ?: 0
        taskManager.removeTask(taskId)
      }
      3 -> taskManager.listTasks()
      4 -> {
        println("Exiting Task Manager. Goodbye!")
        return
      }
      else -> println("Invalid choice. Please enter a valid option.")
    }
  }
}
