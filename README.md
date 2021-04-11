# Multimedia Systems(ITEN3304)
As part of the course ITEN3304 at UOK (University of Kalamoon). We have been asked to create an application on any platform using any programming language to apply the theortical concepts that has been taught during the course

## The Course Covers:
- Image processing basic algorithms
  - Color Filter (Red - Green - Blue)
  - Brightness 
  - Grayscale (Using the 7 algorithms mentioned [here](https://tannerhelland.com/2011/10/01/grayscale-image-algorithm-vb6.html))
  - Invert
  - Contrast
  - Resize
- Data compression 
  - Hoffman encoding
  - LZW 
- Audio and Video representation



## Why Kotlin and Compose multiplatform ?
In the beggining I wasn't going to use Kotlin instead I planned to build a simple windows forms application with C# but Jetbrains [announcement](https://blog.jetbrains.com/cross-post/jetpack-compose-for-desktop-milestone-1-released/) changed my mind. I am very interested in Jetpack Compose and following the progress since it was in alpha stage on Android and the fact that it's now available on desktop (and in the browser soon) forced me to give at a shot. Also I really wanted to test myself the 100% interopoability of composables and whether I'll be able to share the UI composables as-is without making any adjustments or some minor changes. Initilly I was a little bit scared of the multiplatform hassle because I expected that there will be a lot of project setup issues (as usual when it comes to Jetbrains) so I have built my project using compose for desktop only. But now in this repo it's becoming a multiplatform project


## My Expereicne 
So far the developer expereicne is more than good I could say. 

### The good things:
- The claims about the 100% interopoability of composables is correct. All the composables are in the common module. Kotlin-multiplatform now it's more than sharing of the business logic and utility
- No project setup bullsh** (KotlinJS devs will understand) but don't use the project wizard in Intillij clone the template from the [official repo](https://github.com/JetBrains/compose-jb/blob/master/templates/multiplatform-template) instead.

### The challenges: (I won't say bad because Compose still work in progrees and things will change)
- As my app deals with images. Compose only understands `ImageBitmap` and `Painter`. Let's ignore `Painter` cause it's only available on Android. `ImageBitmap` it's the shared interface between the desktop and Android. The problem that I had to make different implementation for each platform because Compose is unaware of the platform that it runs on. So it's the develeper job to cast the `ImageBitmap` to `AndroidImageBitmap` or `DesktopImageBitmap`. I have ended up being not able to share the functions that perform the image processing algorithms which IMO agains the idea of Kotlin-Multiplatform
- On desktop `DesktopImageBitmap` doesn't offer you methods to mutate it. You will have to create BufferedImage to be able to process the pixels of the image. 

