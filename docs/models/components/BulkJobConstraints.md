# BulkJobConstraints

Describes the limits of a bulk job, or an action associated with a bulk job


## Fields

| Field                    | Type                     | Required                 | Description              | Example                  |
| ------------------------ | ------------------------ | ------------------------ | ------------------------ | ------------------------ |
| `allowedFormats`         | List\<*String*>          | :heavy_minus_sign:       | N/A                      | [<br/>"pdf",<br/>"docx",<br/>"txt"<br/>] |
| `maxDocumentsPerJob`     | *Optional\<Integer>*     | :heavy_minus_sign:       | N/A                      | 10000                    |
| `maxSizeMb`              | *Optional\<Integer>*     | :heavy_minus_sign:       | N/A                      | 100                      |
| `timeoutSeconds`         | *Optional\<Integer>*     | :heavy_minus_sign:       | N/A                      | 300                      |