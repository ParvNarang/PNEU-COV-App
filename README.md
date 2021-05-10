# PNEU-COV App
Android app that takes a chest X-ray image as an input and predicts whether or not it is diagnosed with pneumonia.

# Start Activity
![WhatsApp Image 2021-05-10 at 20 42 31 (1)](https://user-images.githubusercontent.com/56078295/117705321-89a94400-b1e9-11eb-8870-0fb2120aa099.jpeg) ![WhatsApp Image 2021-05-10 at 20 42 31](https://user-images.githubusercontent.com/56078295/117705366-94fc6f80-b1e9-11eb-9045-1890cef79239.jpeg)
The first activity has the option of selecting your preffered language.

# Home Page
![WhatsApp Image 2021-05-10 at 20 42 31 (2)](https://user-images.githubusercontent.com/56078295/117705491-bb220f80-b1e9-11eb-964d-c36b7933cca9.jpeg) ![WhatsApp Image 2021-05-10 at 20 42 31 (3)](https://user-images.githubusercontent.com/56078295/117705526-c70dd180-b1e9-11eb-8ccd-9056df033d52.jpeg)
The model for detecting pneumonia was initially trained in python and was converted to .h5 model file. For importing it to Android Studio, tensorflow lite library is required and the h5 model has to be converted into .tflite file.

The input image size is [224,224].

Upload the chest X-ray image using the upload button (which uses the media store library and uri) and click on the select button to make the prediction.

# Result Page

<p float="left">
  <img src="![WhatsApp Image 2021-05-10 at 20 42 31 (5)](https://user-images.githubusercontent.com/56078295/117706832-68495780-b1eb-11eb-9d04-18f699e53c57.jpeg)" width="100" />
  <img src="![WhatsApp Image 2021-05-10 at 20 42 31 (6)](https://user-images.githubusercontent.com/56078295/117706855-713a2900-b1eb-11eb-996c-b18b58804083.jpeg)" width="100" /> 
</p>
