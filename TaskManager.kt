// Task Manager

data class Task(val id: Int, val description: String)

class TaskManager {
  private val tasks = mutableListOf<Task>()
  private var taskIdCounter = 1

  // add task to the task list

  fun addTask(description: String) {
    val task = Task(taskIdCounter++, description)
    tasks.add(task)
    println("Task added: $task")
  }

  // remove task from task list

  fun removeTask(taskId: Int) {
    val taskToRemove = tasks.find { it.id == taskId }
    if (taskToRemove != null) {
      tasks.remove(taskToRemove)
      println("Task removed: $taskToRemove")
    } else {
      println("Task with ID $taskId not found.")
    }
  }

  // if the user eneters incorrect task, no task availabe will be displayed

  fun listTasks() {
    if (tasks.isEmpty()) {
      println("No tasks available.")
    } else {
      println("Task List:")
      tasks.forEach { println(it) }
    }
  }
}

// Task list menu

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

        //  user to enter task ID

      }
      2 -> {
        print("Enter task ID to remove: ")
        val taskId = readLine()?.toIntOrNull() ?: 0
        taskManager.removeTask(taskId)
      }

      // USER exist task app

      3 -> taskManager.listTasks()
      4 -> {
        println("Exiting Task Manager. Goodbye!")
        return

        // allow the user to enter a valid choice again

      }
      else -> println("Invalid choice. Please enter a valid option.")
    }
  }
}
