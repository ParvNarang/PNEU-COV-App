# PNEU-COV App
Android app that takes a chest X-ray image as an input and predicts whether or not it is diagnosed with pneumonia.

# Start Activity
<p align="center">
  <img src="https://github.com/ParvNarang/PNEU-COV-App/blob/d05e684f570c06760b7546372c354898081691ec/images/1.jpeg" width="350">
</p>

The first activity has the option of selecting your preffered language.

# Home Page

The model for detecting pneumonia was initially trained in python and was converted to .h5 model file. For importing it to Android Studio, 
tensorflow lite library is required and the h5 model has to be converted into .tflite file.

The input image size is [224,224].

Upload the chest X-ray image using the upload button (which uses the media store library and uri) and click on the select button to make the prediction.

# Result Page


