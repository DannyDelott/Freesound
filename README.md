Freesound Dataset Builder
=======================

This Java program provides functionality for downloading audio files from the Freesound API.
 
    
##How it Works

The Freesound Dataset Builder is an executable JAR file that logs into the [Freesound APIv2](http://www.freesound.org/docs/api/) on the user's behalf and automates the process of downloading raw audio files and the meta-data associated with them. 
##Download
The `freesound.jar` file is an executable JAR that contains the entire Freesound Dataset builder program.  Users who only wish to use the program as-is should simply download this file and run it.  See [Usage](#usage).

Also, users who are interested in making changes or compiling the program on their own are encouraged to download the Java project files in the Freesound directory and tinker away!

##New Users 
You must authorize the Freesound Dataset Builder to make API calls on your behalf by logging into the Freesound API with your Freesound account username and password. 

On the initial launch, the default web browser is opened automatically to the Freesound API login screen.  Once logged in, click "Authorize" and copy and paste the authorization code into the Freesound Dataset Builder.  After this initial authorization, a file named `refresh_token.json` will be generated and used to automate the authorization process for future runs. 

##Usage
To use the tool, simply open a Terminal window, navigate to the directory containing the "freesound.jar" file, and append the following runtime arguments at launch:

    java -jar freesound.jar <KEYWORD_IN_QUOTES> <MIN_DURATION_IN_SECONDS> <MAX_DURATION_IN_SECONDS> <QUANTITY_TO_DOWNLOAD> <FILETYPE_IN_QUOTES>
    
**Examples:**

*     java -jar freesound.jar "cell phone" 1 5 25 "*"
This will download 25 audio files of any format between 1 and 5 seconds long that contain the search term "cell phone".

*     java -jar freesound.jar "barking" 3 15 30 "wav"
This will download 30 .wav audio files between 3 and 15 seconds long that contain the search term "barking".


##Requirements

Freesound Dataset Builder requires Java.  Download the latest version [here](http://www.java.com).
    
##Possible Issues

* Users who do not have the `refresh_token.json` file or have one that contains an expired refresh token must re-authenticate as if they were new users.  See [New Users](#new-users).

* It is possible that the value given for `<QUANTITY_TO_DOWNLOAD>` at runtime is larger than the number of audio files available on Freesound.  In this case, the Freesound Dataset Builder will download the total number of search results and display the following message:
    

*     WARNING: The quantity to download is larger than the number of available search results.

* The Freesound API will thottle users who are accessing over 60 audio files per minute.  When this happens, the Freesound Dataset Builder will timeout for 60 seconds then continue where it left off. 


##Credits

Mentor: Dr. Garrett Kenyan

