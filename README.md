# ViewBindingDelegate - Make Android ViewBinding Easy

ViewBindingDelegate is a library that simplifies the usage of Android's ViewBinding feature by providing convenient delegate properties for activities, fragments, dialog fragments, view groups, and RecyclerView view holders. This library aims to reduce boilerplate code and improve the readability of your UI-related code.

## Features

* Easily bind views using ViewBinding without repetitive code.
* Provides delegate properties for activities, fragments, dialog fragments, view groups, and RecyclerView view holders.
* Automatically clears the binding instance when the associated lifecycle is destroyed, preventing memory leaks.

## Setup

To integrate ViewBindingDelegate into your project, follow these steps:
1. Open your app-level build.gradle file.
2. Add the following dependency to your dependencies block:
```gradle
dependencies {
    implementation 'io.github.cooliceman:view-binding-delegate:<latest_version>'
}
```
Replace <latest_version> with the latest version of the library, which you can find in the releases section.

## Usage

1. ViewBinding for Activity
```kotlin
class MyActivity : ComponentActivity() {
    private val binding by viewBinding(ActivityMyBinding::inflate)
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        
        // Access views through binding instance
        binding.textView.text = "Hello, ViewBindingDelegate!"
    }
}
```

2. ViewBinding for Fragment
```kotlin
class MyFragment : Fragment(R.layout.fragment_my) {
    private val binding by viewBinding(FragmentMyBinding::bind)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Access views through binding instance
        binding.textView.text = "Hello from Fragment!"
    }
}
```

3. ViewBinding for DialogFragment
```kotlin
class MyDialogFragment : DialogFragment() {
    private val binding by viewBinding(DialogFragmentMyBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_fragment_my, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Access views through binding instance
        binding.textView.text = "Hello from DialogFragment!"
    }
}
```

4. ViewBinding for ViewGroup
```kotlin
class MyCustomViewGroup(context: Context, attrs: AttributeSet) : ViewGroup(context, attrs) {
    private val binding by viewBinding(ViewGroupMyBinding::bind)
    
    init {
        inflate(context, R.layout.view_group_my, this)
        // Access views through binding instance
        binding.textView.text = "Hello from Custom ViewGroup!"
    }
}
```

5. ViewBinding for RecyclerView ViewHolder
```kotlin
class MyViewHolder(private val binding: RecyclerViewItemBinding) : RecyclerView.ViewHolder(binding.root) {
    
    // Access views through binding instance
    fun bind(data: MyData) {
        binding.textView.text = data.text
    }
}
```

## Attention
If you use view binding in your fragment, when you want to access the view binding object in post functions or animation end listeners, 
you should check whether the fragment is still attached to the activity, otherwise you will get exception.

```kotlin
class MyFragment : Fragment(R.layout.fragment_my) {
    private val binding by viewBinding(FragmentMyBinding::bind)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Access views through binding instance
        binding.textView.text = "Hello from Fragment!"
        
        // If you want to access the view binding object in post functions or animation end listeners, 
        // you should check whether the fragment is still attached to the activity, otherwise you will get a exception.
        binding.textView.post {
            if (!isAdded) {
                return@post
            }
            binding.textView.text = "Hello from post!"
        }
    }
}
```
## License
This library is distributed under the Apache License, Version 2.0. See LICENSE for more information.

## Contributing
Contributions are welcome! If you find any issues or have suggestions for improvement, please [create an issue](https://github.com/cooliceman/ViewBindingDelegate/issues) or submit a pull request.
