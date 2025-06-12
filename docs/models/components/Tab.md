# Tab


## Fields

| Field                                                                 | Type                                                                  | Required                                                              | Description                                                           |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| `extensionData`                                                       | [TabExtensionData](../../models/components/TabExtensionData.md)       | :heavy_check_mark:                                                    | N/A                                                                   |
| `tabType`                                                             | *String*                                                              | :heavy_check_mark:                                                    | Indicates the type of tab                                             |
| `validationPattern`                                                   | *Optional\<String>*                                                   | :heavy_minus_sign:                                                    | A regular expression used to validate input for the tab.              |
| `validationMessage`                                                   | *Optional\<String>*                                                   | :heavy_minus_sign:                                                    | The message displayed if the custom tab fails input validation        |
| `tabLabel`                                                            | *String*                                                              | :heavy_check_mark:                                                    | The label associated to a verification field in a document.           |
| `radios`                                                              | List\<*String*>                                                       | :heavy_minus_sign:                                                    | The radio button properties for the tab (if the tab is of radio type) |