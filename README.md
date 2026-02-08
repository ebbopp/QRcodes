# Custom QR Code Generator

![Build Status](https://github.com/ebbopp/QRcodes/actions/workflows/build.yml/badge.svg)

A Java Swing-based application for generating customized QR codes with vCard information. This application allows users to create professional QR codes containing contact information with company branding.

## Features

- **vCard QR Code Generation**: Create QR codes containing contact information compatible with mobile devices
- **Custom Branding**: Incorporates company logo and branding colors into QR codes
- **Multiple Office Locations**: Pre-configured support for multiple office addresses
- **Interactive GUI**: Easy-to-use Swing interface for data entry
- **High-Quality Output**: Generate QR codes at 3000x3000 pixel resolution
- **Save Functionality**: Export generated QR codes as PNG images

## Prerequisites

- **Java**: JDK 8 or higher
- **Maven**: Apache Maven 3.6 or higher (only for building from source)

### Verify Prerequisites

```bash
java -version
mvn -version
```

## Installation

### Option 1: Download Pre-built Release (Recommended)

Visit the [Releases page](https://github.com/ebbopp/QRcodes/releases) and download the latest version:

#### For All Platforms (Windows/Mac/Linux)
1. Download `qr-code-generator-{version}.jar`
2. Ensure Java 8 or higher is installed
3. Run with: `java -jar qr-code-generator-{version}.jar`

#### For Windows Users
1. Download `qr-code-generator-{version}.exe`
2. Double-click to run (Java 8+ required but bundled)
3. Or run from command line: `qr-code-generator-{version}.exe`

#### For Linux Users
1. Download `qr-code-generator-{version}-linux.zip`
2. Extract the archive
3. Run: `./QRCodeGenerator/bin/QRCodeGenerator`

### Option 2: Build from Source

## Building the Project

To build the project and create an executable JAR:

```bash
mvn clean package
```

This will:
1. Compile the source code
2. Run any tests (if present)
3. Package the application into an executable JAR with all dependencies included
4. Place the output in the `target/` directory

## Running the Application

After building the project, run the application using:

```bash
java -jar target/qr-code-generator-1.0.0-jar-with-dependencies.jar
```

### Using the Application

1. **Enter Contact Information**:
   - First Name and Last Name (required)
   - Job Title
   - Phone Number
   - Email ID (everything before the @ symbol - the application automatically appends @skaeng.com)
   - LinkedIn profile (everything after linkedin.com/in/)
   - Office Location (can use full names or abbreviations)

2. **Supported Office Locations**:
   - Charlotte (CLT)
   - Greensboro (GSO)
   - Wilmington (ILM)
   - Asheville (ASH)
   - Raleigh/Durham (RDU)
   - Charleston (CHS)
   - Charlottesville (CHO)

3. **Generate QR Code**: Click the "Generate QR Code" button to create your customized QR code

4. **Save QR Code**: Click "Save QR Code" to export the generated image to your desired location

## CI/CD Pipeline

This project uses GitHub Actions for automated building, testing, and releases.

### Automated Builds

Every push to `main` and every pull request triggers automated builds on:
- Ubuntu (Linux)
- Windows
- macOS

The build workflow:
1. Sets up Java 17
2. Caches Maven dependencies for faster builds
3. Runs `mvn clean verify` to compile and test
4. Uploads JAR artifacts for inspection

### Creating a Release

Releases are automatically created when you push a version tag. Here's how:

1. **Update version in `pom.xml`**:
   ```xml
   <version>1.0.1</version>
   ```

2. **Commit the version change**:
   ```bash
   git add pom.xml
   git commit -m "Release v1.0.1"
   ```

3. **Create and push the tag**:
   ```bash
   git tag v1.0.1
   git push origin main --tags
   ```

4. **Automated Release Process**:
   - GitHub Actions automatically triggers
   - Builds the project on Linux and Windows
   - Creates executable JAR with all dependencies
   - Generates Windows .exe installer using jpackage
   - Creates Linux standalone application
   - Creates GitHub Release with all artifacts
   - Generates release notes with installation instructions

### Release Artifacts

Each release automatically provides:
- **Universal JAR** (`qr-code-generator-{version}.jar`) - Works on all platforms with Java
- **Windows Installer** (`qr-code-generator-{version}.exe`) - Native Windows executable
- **Linux Standalone** (`qr-code-generator-{version}-linux.zip`) - Standalone Linux application
- **Source Code** - Automatically provided by GitHub

## Development

### Importing into IDEs

#### Eclipse

1. Select `File > Import > Maven > Existing Maven Projects`
2. Browse to the project directory
3. Click Finish

#### IntelliJ IDEA

1. Select `File > Open`
2. Navigate to the project directory and select the `pom.xml` file
3. Click OK and select "Open as Project"

### Project Structure

```
QRcodes/
├── pom.xml                          # Maven build configuration
├── README.md                        # This file
├── src/
│   └── main/
│       ├── java/
│       │   └── generareQr/
│       │       └── QRCodeGenerator.java  # Main application class
│       └── resources/
│           └── images/
│               └── SKA only square.png   # Company logo for QR codes
└── target/                          # Build output directory (generated)
```

## Dependencies

This project uses the following libraries:

- **ZXing 3.4.1** - QR code generation and barcode processing
  - `com.google.zxing:core` - Core barcode encoding/decoding library
  - `com.google.zxing:javase` - Java SE-specific extensions
- **Apache Commons Lang3 3.12.0** - Java utility library
- **JAI ImageIO Core 1.4.0** - Advanced image I/O operations

## License

This project incorporates several open-source libraries:

- **ZXing**: Licensed under the Apache License 2.0
- **Apache Commons Lang**: Licensed under the Apache License 2.0
- **JAI ImageIO**: Available under multiple licenses (see extracted/META-INF/LICENSE files for details)

For complete license information, see the license files in the `extracted/META-INF/` directory.

## Technical Details

### QR Code Specifications

- **Format**: vCard 3.0
- **Error Correction Level**: L (Low) - ~7% error correction
- **Size**: 3000x3000 pixels (displayed at 300x300 in GUI)
- **Colors**: Custom company branding (#000066)
- **Logo**: Embedded company logo with border

### vCard Fields

The generated QR codes include:
- Full Name (FN)
- Structured Name (N)
- Organization (ORG)
- Job Title (TITLE)
- Telephone (TEL)
- Email (EMAIL)
- URL (LinkedIn profile)
- Address (ADR) - Based on selected office location

## Troubleshooting

### Build Issues

If you encounter build issues:

```bash
# Clean and rebuild
mvn clean install

# Skip tests if necessary
mvn clean package -DskipTests
```

### Runtime Issues

- Ensure Java 8 or higher is installed
- Verify the JAR file is not corrupted
- Check that image resources are properly bundled in the JAR

## Contributing

When modifying the code:

1. Maintain the existing package structure (`generareQr`)
2. Update this README if adding new features
3. Test the application thoroughly before committing changes
4. Rebuild the JAR and verify it works as expected
