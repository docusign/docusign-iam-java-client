# TabConnectedFieldsData


## Fields

| Field                                                               | Type                                                                | Required                                                            | Description                                                         |
| ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- |
| `typeSystemNamespace`                                               | *String*                                                            | :heavy_check_mark:                                                  | The fully qualified namespace for the type system being verified.   |
| `typeName`                                                          | *String*                                                            | :heavy_check_mark:                                                  | Name of the type being verified.                                    |
| `supportedOperation`                                                | [SupportedOperation](../../models/components/SupportedOperation.md) | :heavy_check_mark:                                                  | The operation that the field supports.                              |
| `propertyName`                                                      | *String*                                                            | :heavy_check_mark:                                                  | The name of the individual field being verified.                    |
| `supportedUri`                                                      | *String*                                                            | :heavy_check_mark:                                                  | Indicates the type verification url of the field.                   |