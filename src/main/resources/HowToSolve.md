Follow these tips from Facebook engineers so you’re prepared for your coding interview.
Make sure you understand the question. Read the question back to your interviewer and ask any clarifying questions. 

An interview is a two-way conversation; feel free to ask questions you might have.
Take time to consider your approach instead of rushing through your solutions. 

For example, on a tree question, you'll need to choose between an iterative or a recursive approach. 

It's OK first to use a working, unoptimized solution that you can iterate on later. 

Talk through your thinking and processes out loud. This can feel unnatural, so be sure to practice beforehand.
Test your code by running through your problem with a few test and edge cases. 

Again, talk through your logic out loud when you walk through your test cases.
Think of ways your solution could be better, and try to improve it. 

When you’ve finished, your interviewer will ask you to analyze the complexity of the code in Big O notation. 

Walk through your code line by line and assign a complexity to each line.

Facebook Technical Interview Video (Password is fbprep)

Interview Problem Walk-Through (Password is FB_IPS)

#Walk through a problem:

Given a list of birth year, death years of people. Find the year with the highest population of people alive.

What data structures is the info coming? 
All aren't alive at same time.
Ask questions.
Look for clues


Draw complete examples, with relevant info only: 

dont need name; just need dates.
ensure your test case is not a special case (every body should be alive at same time), and its not BIG test case

make a generic, and realistic example.  Data shouldn't be sorted, etc.

Bruth force:

Check each year and get people alive in each year.
1. Get min year O(P) //P is people number
2. Get max year O(P)
3. O(Y. P ) // Y is range of the year of people and getting people alive in each


total run time: o(py)


dont code, figure out an optimal solution.

## Note your things your brain does things automatically without you realizing it.

Dont need to check each year, only the year someones born or died.

ask more questions if they arise: if more than one year has same highest number, what do I send? range, list all, or first one?


hashset for unique years O (U.P)

## Cut out non-required work.  YOu care to get the MAX population, so birth years are importnat not ALL death years
