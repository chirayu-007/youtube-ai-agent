# YouTube AI Content Strategist (Backend) 🚀

An intelligent Spring Boot backend application that extracts highly relevant YouTube comments and feeds them into Google's Gemini AI to generate actionable video ideas for content creators.

## 🌟 Current Features (Phase 1 & 2)
* **Smart YouTube Extraction:** Connects to the YouTube Data API v3 to fetch comments.
* **Algorithmic Sorting:** Uses `order=relevance` to pull the highest quality, most engaged comments first.
* **Custom Pagination:** Allows users to define API quota limits (e.g., fetch exactly 300 or 500 comments).
* **Data Cleansing Pipeline:** Utilizes Java Streams to filter out spam, short messages, and low-quality data before AI processing.
* **Secure Architecture:** Requires the user to pass their own API keys via POST request, keeping the server stateless and secure.

## 🛠️ Tech Stack
* **Framework:** Java, Spring Boot 3
* **APIs:** YouTube Data API v3, Google Gemini API
* **Client:** Spring `RestClient`

## 🚀 How to Run Locally

1. **Clone the repository**
   ```bash
   git clone [https://github.com/chirayu-007/youtube-ai-agent.git](https://github.com/chirayu-007/youtube-ai-agent.git)

Setup your environment
Ensure you have Java 17+ installed. No hardcoded API keys are required in the application.properties as they are passed via the request payload.

Run the application

Bash
./mvnw spring-boot:run
📡 API Endpoints
1. Fetch & Filter Comments
   POST /api/comments
   Retrieves and cleans comments from a specific YouTube video.

Request Body:

JSON
{
"apiKey": "YOUR_YOUTUBE_API_KEY",
"videoId": "8U0LFpEe8oA",
"maxPages": 3
}
🗺️ Roadmap / Coming Soon
[ ] Connect Gemini AI service to the Controller.

[ ] Implement Global Exception Handling (400/500 errors).

[ ] Build a React/Next.js Frontend interface.