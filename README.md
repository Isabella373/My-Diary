# Diary

## What the application can do?


- Record daily events, thoughts and feelings through pictures, videos, meme and words. 

- Track daily spending, and monthly reflect proportion to help manage personal finances




## Why is this project of interest to me?


- Marquez once said,"What matters in life is not what happens to you,but what you remember." There are many beautiful moments and feelings that worth recording. And diary allows us to record whenever and wherever. 
- I like keeping dairy. It is a fantastic way to express all the frustrated feeling and release my pressure.
- Nowadays, people record and share their life through social media, but sometimes what we share is not always our real life and real feeling. Diary can create a secret space for your own.
- I always found that my money in the bank secretly disappear in a fantastic speed. Diary can help you record when and how you spend money. It is very convenient, just add an entry and short description to your diary. You can also know the proportion you spend for each aspect, education,entertainment...

## User Stories
- As a user, I want to be able to add words to my Today's diary
- As a user, I want to be able to create a new Today's diary with time
- As a user, I want to be able to add my feeling to the new diary
- As a user, I want to be able to add my diaries to the previous diaries list


- As a user, I want to be able to save my diary to file
- As a user, I want to be able to load my diary from file
- As a user, when I select the quit option from the application menu, I want to be
- reminded to save my diary list to file and have the option to do so or not.
- As a user, when I start the application, I want to be given the option to load my diary 
- from file.


## Phase 4 Task 2 (Sample)
Fri Apr 01 05:04:08 PDT 2022
New Category SAD was added to the diary

Fri Apr 01 05:04:08 PDT 2022
New time April / 1 / FRIDAY was added to the diary

Fri Apr 01 05:04:08 PDT 2022
Add a new diary to the Previous diaries

## Phase 4 Task 3 (Changes)
1. Since YesOrNOPage, ImagePage,MainPage all have one JsonWriter and one JsonReader as field,
and they all extend JFrame, the Structure of them are relatively very similar, I will create an 
abstract class for these three class to extend, so that the code will be more simplified
2. Since there are 6 Class (SecondPage, StartPage, TimePage, SaveSuccessfulPage, GoodbyePage and FeelingPage)
they all extend JFrame and all have same fields and similar code structure, I can also create 
a class for them to extend
3. I will simplify the replicated code in the MainPage class, because I added many buttons to the
main page, the code for these buttons are duplicated, only the behaviour after we press the buttons
are different.



## In the end
It is an application for everyone who would like to record daily life and spending 



