# GetWorkspaceBrandResponse

The details of a single workspace brand


## Fields

| Field                                                          | Type                                                           | Required                                                       | Description                                                    |
| -------------------------------------------------------------- | -------------------------------------------------------------- | -------------------------------------------------------------- | -------------------------------------------------------------- |
| `brandId`                                                      | *JsonNullable\<String>*                                        | :heavy_minus_sign:                                             | N/A                                                            |
| `brandName`                                                    | *JsonNullable\<String>*                                        | :heavy_minus_sign:                                             | N/A                                                            |
| `brandCompany`                                                 | *JsonNullable\<String>*                                        | :heavy_minus_sign:                                             | N/A                                                            |
| `colors`                                                       | List\<[BrandColor](../../models/components/BrandColor.md)>     | :heavy_check_mark:                                             | N/A                                                            |
| `logos`                                                        | [Optional\<BrandLogos>](../../models/components/BrandLogos.md) | :heavy_minus_sign:                                             | N/A                                                            |
| `brandLanguages`                                               | List\<*String*>                                                | :heavy_check_mark:                                             | N/A                                                            |
| `defaultBrandLanguage`                                         | *JsonNullable\<String>*                                        | :heavy_minus_sign:                                             | N/A                                                            |
| `isSendingDefault`                                             | *Optional\<Boolean>*                                           | :heavy_minus_sign:                                             | N/A                                                            |
| `isSigningDefault`                                             | *Optional\<Boolean>*                                           | :heavy_minus_sign:                                             | N/A                                                            |
| `primaryLogoId`                                                | *JsonNullable\<String>*                                        | :heavy_minus_sign:                                             | N/A                                                            |
| `secondaryLogoId`                                              | *JsonNullable\<String>*                                        | :heavy_minus_sign:                                             | N/A                                                            |
| `emailLogoId`                                                  | *JsonNullable\<String>*                                        | :heavy_minus_sign:                                             | N/A                                                            |