# Custom QR Code Generator

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
- **Maven**: Apache Maven 3.6 or higher

### Verify Prerequisites

```bash
java -version
mvn -version
```

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

## Creating an Executable (.exe) with Launch4j

To create a Windows executable (.exe) wrapper for the JAR file:

1. Download and install [Launch4j](http://launch4j.sourceforge.net/)

2. Configure Launch4j:
   - **Output file**: `qr-code-generator.exe`
   - **Jar**: `target/qr-code-generator-1.0.0-jar-with-dependencies.jar`
   - **Min JRE version**: 1.8.0

3. Build the executable using the Launch4j GUI or command line

For detailed instructions, refer to the [Launch4j Documentation](http://launch4j.sourceforge.net/docs.html).

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
