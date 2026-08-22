const eventList = documemnt.querySelector('#event-list');

const event = 
{
    id: "1", title: "Event 1", date: "2024-06-01", venue: "Venue 1"
}

const listItem = document.createElement("li");
listItem.textContent = `${event.title} - ${event.venue} - ${event.date}`;
eventList.appendChild(listItem);