# ChaniBot User Guide

![Chani Screenshot](ui.png)

Chani is your sad chatbot to help you manage tasks efficiently. Do not abuse it too much.
It can add, list, mark as done, and delete tasks, all through a simple chat interface.

## Features
- Commands are **case-sensitive**.
- Always use the **task number** from the latest `list` output when marking done, unmarking, or deleting.
- If a command fails (e.g., invalid number, wrong date format), Chani will display an error message.
- Tasks are only saved when exiting using `bye`.
- only Deadlines tasks require specific date/time formats; Chani will validate your input.


## Listing Tasks

View all tasks in your list.

**Command:** `list`

**Example:** 
`list`

---

## Exiting Chani

Save your tasks and exit the chatbot.

**Command:** `bye`

**Example:** 
`bye`

---

## Marking Tasks as Done

Mark a task as completed.

**Command:** `mark <task number>`

**Example:**  
`mark 1`

---

## Unmarking Tasks

Mark a previously done task as not done.

**Command:** `unmark <task number>`

---

## Deleting Tasks

Remove a task from your list.

**Command:** `delete <task number>`

**Example:**  
`delete 2`

---

## Finding Tasks

Search for tasks containing a specific keyword.

**Command:** `find <query>`

**Example:**  
`find homework`


---

## Adding Todos

Add a new todo task to your list.

**Command:** `todo <task description>`

**Example:**  
`todo Finish CS2103T project`

---

## Adding Deadlines

Add a new deadline task to your list.

**Command:** `deadline <desc> /by <yyyy-mm-dd>`

**Example:**  
`deadline Finish homework /by 2025-02-03`

---

## Adding Events

Add a new event with start and end times.

**Command:** `event <desc> /from <start> /to <end>`

**Example:**  
`event Team meeting /from 14:00 /to 16:00`

---

## Adding Period Tasks

Add a task for a period of time.

**Command:** `period <desc> /between <start> /and <end>`

**Example:**  
`period Project work /between 2025-02-01 /and 2025-02-10`

