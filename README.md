
# GetHymnLyrics

A tool to help importing SDA Hymns into ProPresenter quickly. This tool has lyrics to most hymns found in the SDA Hymnal and will output to ProPresenter format to clipboard.
Then all you need to do is import from clipboard.

This tool was created a couple years ago to select hymns quickly on the fly when the worship team gives you a list of hymns seconds before the service starts.




## Features

- Hymns to clipboard in ProPresenter format
- Easy and quick to use
- Hymns in seconds

## Folder Structure

The workspace contains three folders, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies
- `data`: contains the xml file with the hymn lyrics

Meanwhile, the compiled output files will be generated in the `bin` folder by default.
## Run Locally

Clone the project

```bash
  git clone https://link-to-project
```

Go to the project directory

```bash
  cd my-project
```

If using the java VSCode extensions simply open the project folder in vscode and run.

Otherwise, go to the src directory

```bash
  cd src
```

Compile class files

```bash
  javac GetHymnLyrics
```

Run

```bash
  java GetHymnLyrics
```

To build as a jar

```bash
  jar -cf GetHymnLyrics.jar GetHymnLyrics.class
```

When running the application, __always__ make sure that the __data__ folder is present otherwise it will not work!
## Contributing

Contributions are always welcome!

Create a pull request and I will take a look

## Authors

- [@lindsaysperring](https://www.github.com/lindsaysperring)


## License

[GNU AGPLv3 ](https://choosealicense.com/licenses/agpl-3.0/)

