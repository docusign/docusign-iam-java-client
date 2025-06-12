# GetAgreementsListRequest


## Fields

| Field                                                              | Type                                                               | Required                                                           | Description                                                        | Example                                                            |
| ------------------------------------------------------------------ | ------------------------------------------------------------------ | ------------------------------------------------------------------ | ------------------------------------------------------------------ | ------------------------------------------------------------------ |
| `accountId`                                                        | *Optional\<String>*                                                | :heavy_check_mark:                                                 | N/A                                                                |                                                                    |
| `limit`                                                            | *JsonNullable\<Integer>*                                           | :heavy_minus_sign:                                                 | The maximum number of items that can be returned in a single page. | 10                                                                 |
| `ctoken`                                                           | *JsonNullable\<String>*                                            | :heavy_minus_sign:                                                 | An opaque token that helps retrieve the a page of data.            | abc123                                                             |